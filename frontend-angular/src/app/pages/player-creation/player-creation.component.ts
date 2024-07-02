import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { Router } from '@angular/router';
import { Player } from '../../model/player';

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
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
  ],
  templateUrl: './player-creation.component.html',
  styleUrl: './player-creation.component.scss',
})
export class PlayerCreationComponent {
  player: Player = {
    id: null,
    name: '',
    email: '',
    phone: '',
    codeName: null,
    playerGroup: null,
  };

  constructor(private router: Router) {}

  listerPlayer(): void {
    this.router.navigate(['']);
  }

  registerPlayer(): void {
    console.log(this.player.name);
  }
}
