import { Component, signal } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { Router } from '@angular/router';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { PlayerService } from '../../service/player.service';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { NgxMaskDirective, NgxMaskPipe } from 'ngx-mask';

@Component({
  selector: 'app-player-creation',
  standalone: true,
  imports: [
    MatDividerModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    NgxMaskDirective,
    NgxMaskPipe,
  ],
  templateUrl: './player-creation.component.html',
  styleUrl: './player-creation.component.scss',
})
export class PlayerCreationComponent {
  formData: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.maxLength(100)]),
    email: new FormControl('', [
      Validators.required,
      Validators.email,
      Validators.maxLength(50),
    ]),
    phone: new FormControl('', [
      Validators.required,
      Validators.maxLength(20),
    ]),
    group: new FormControl('', [Validators.required]),
  });
  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  phoneMask: string = ''

  constructor(
    private router: Router,
    private snackBar: MatSnackBar,
    private playerService: PlayerService
  ) {}

  listerPlayer(): void {
    this.router.navigate(['']).then(() => location.reload());
  }

  registerPlayer(): void {
    if (!this.formData.invalid) {
      const data = {
        name: this.formData.value.name,
        email: this.formData.value.email,
        phone: this.getPhoneMask(),
        type: this.formData.value.group,
      };

      this.playerService
        .registerPlayer(data)
        .pipe(
          catchError((err) =>
            throwError(() => this.showMessage(err.error.message))
          )
        )
        .subscribe(() => {
          this.router.navigate(['']).then(() => location.reload());
        });
    }
  }

  setPhoneMask(phone: string) {
    this.phoneMask = phone;
  }

  getPhoneMask() {
    return this.phoneMask;
  }

  private showMessage(message: string) {
    this.snackBar.open(`${message}`, 'Splash', {
      duration: 3000,
    });
  }

  getErrorMessage(fieldName: string): string {
    const field = this.formData.get(fieldName);

    if (field?.hasError('required')) {
      return 'field required';
    }
    if (field?.hasError('email')) {
      return 'field invalid';
    }
    if (field?.hasError('maxlength') && field.errors) {
      const length = field.errors['maxlength'];
      return `field not should be more than ${length.requiredLength}`;
    }

    return 'field invalid';
  }
}
