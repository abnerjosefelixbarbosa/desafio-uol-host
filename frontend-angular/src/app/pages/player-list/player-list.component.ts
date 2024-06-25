import { ChangeDetectionStrategy, Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';

@Component({
  selector: 'app-player-list',
  standalone: true,
  imports: [
    MatDividerModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatListModule,
  ],
  templateUrl: './player-list.component.html',
  styleUrl: './player-list.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PlayerListComponent {}
