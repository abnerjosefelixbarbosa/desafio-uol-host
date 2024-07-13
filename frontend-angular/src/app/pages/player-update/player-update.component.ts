import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayerService } from '../../service/player.service';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { MatDividerModule } from '@angular/material/divider';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import {
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { NgxMaskDirective, NgxMaskPipe } from 'ngx-mask';
import { Player } from '../../model/player';

@Component({
  selector: 'app-player-update',
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
    NgxMaskDirective,
    NgxMaskPipe,
  ],
  templateUrl: './player-update.component.html',
  styleUrl: './player-update.component.scss',
})
export class PlayerUpdateComponent {
  formData: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.maxLength(100)]),
    email: new FormControl('', [
      Validators.required,
      Validators.email,
      Validators.maxLength(50),
    ]),
    phone: new FormControl('', [Validators.required, Validators.maxLength(20)]),
  });
  phoneMask: string = '';
  player: Player | null = null;
  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  constructor(
    private activatedRoute: ActivatedRoute,
    private playerService: PlayerService,
    private snackBar: MatSnackBar,
    private router: Router
  ) {
    this.getPlayerById();
  }

  getPlayerById() {
    const id = this.activatedRoute.snapshot.queryParamMap.get('id')!;

    this.playerService
      .getPlayerById(id)
      .pipe(
        catchError((err) => {
          return throwError(() => {
            this.showMessage(err.error.message);
          });
        })
      )
      .subscribe((res) => (this.player = res));
  }

  updatePlayer(data: FormGroup) {
    if (!data.invalid) {
      const player: Player = {
        id: this.player?.id!,
        name: data.value.name,
        email: data.value.email,
        phone: this.getPhoneMask(),
        codeName: this.player?.codeName!,
        playerGroup: this.player?.playerGroup!
      }

      this.playerService
        .updatePlayer(player.id!, player)
        .pipe(
          catchError((err) => {
            return throwError(() => {
              this.showMessage(err.error.message);
            });
          })
        )
        .subscribe(() => {
          this.router.navigate(['']).then(() => {
            location.reload();
          });
        });
    }
  }

  listPlayer() {
    this.router.navigate(['']).then(() => location.reload());
  }

  private showMessage(message: string) {
    this.snackBar.open(`${message}`, 'Splash', {
      duration: 3000,
    });
  }

  setPhoneMask(phone: string) {
    this.phoneMask = phone;
  }

  getPhoneMask() {
    return this.phoneMask;
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
