import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';
import { filter } from 'rxjs';

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
    NgFor,
    NgIf
  ],
  templateUrl: './player-creation.component.html',
  styleUrl: './player-creation.component.scss',
})
export class PlayerCreationComponent {
  formData = new FormGroup({
    name: new FormControl('',
      [
        Validators.required,
        Validators.maxLength(100),
      ]),
    email: new FormControl('', 
      [
        Validators.required,
        Validators.email,
        Validators.maxLength(50),
      ]),
    phone: new FormControl('',
      [
        Validators.required,
        Validators.maxLength(20),
      ]),
    group: new FormControl('', 
      [
        Validators.required,
      ]),
  });

  constructor(private router: Router) { 
  }

  listerPlayer(): void {
    this.router.navigate(['']);
  }

  registerPlayer(): void {
    
  }

  getErrorMessage(fieldName: string): string {
    const field = this.formData.get(fieldName);

    if (field?.hasError('required')) {
      return 'field required';
    }
    if (field?.hasError('email')) {
      return 'field invalid'
    } 
    if (field?.hasError('maxlength') && field.errors) {
      const length = field.errors['maxlength'];
      return `field should be max length ${length.requiredLength}`;
    }

    return 'field invalid';
  }
}