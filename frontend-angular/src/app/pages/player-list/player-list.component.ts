import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatTableModule } from '@angular/material/table';
import { Player } from '../../model/player';
import { PlayerService } from '../../service/player.service';

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
  columns = ['name'];
  playerService: PlayerService;

  constructor(playerService: PlayerService) {
    this.playerService = playerService;
  }

  listPlayer(): void {
    this.players = this.playerService.listPlayer();
  }

  ngOnInit(): void {
    this.listPlayer();
  }
}
