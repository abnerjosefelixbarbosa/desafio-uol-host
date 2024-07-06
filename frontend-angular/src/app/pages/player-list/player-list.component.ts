import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatTableModule } from '@angular/material/table';
import { Player } from '../../model/player';
import { PlayerService } from '../../service/player/player.service';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';

@Component({
  selector: 'app-player-list',
  standalone: true,
  imports: [
    MatDividerModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatTableModule,
  ],
  templateUrl: './player-list.component.html',
  styleUrl: './player-list.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PlayerListComponent implements OnInit {
  players: Player[] = [];
  columns = ['name', 'email', 'phone', 'codeName', 'playerGroup'];

  constructor(private router: Router, private playerService: PlayerService, private snackBar: MatSnackBar) {}

  registerPlayer(): void {
    this.router.navigate(['player_creation']);
  }

  listPlayers(): void {
    this.playerService
      .listPlayers()
      .pipe(
        catchError((err) => {
          return throwError(() => {
            this.snackBar.open(`${err.error.message}`, 'Splash', {
              duration: 3000,
            });
          });
        })
      )
      .subscribe((res) => {
        this.players = res.content;
      });
  }

  ngOnInit(): void {
    this.listPlayers();
  }
}
