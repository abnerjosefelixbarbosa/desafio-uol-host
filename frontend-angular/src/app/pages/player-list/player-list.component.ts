import {
  ChangeDetectionStrategy,
  Component,
  Inject,
  OnInit,
} from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatTableModule } from '@angular/material/table';
import { Player } from '../../model/player';
import { PlayerService } from '../../service/player.service';
import { Router } from '@angular/router';

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

  constructor(private playerService: PlayerService, private router: Router) {}

  registerPlayer(): void {
    /*
    const data = {
      name: 'name1',
      email: 'email1@gmail.com',
      phone: '(81) 91111-1101',
      type: PlayerGroup.AVENGERS,
    };

    this.playerService
    .registerPlayer(data)
    .subscribe((response) => {
      this.players.push({
        id: response.id,
        name: response.name,
        email: response.email,
        phone: response.phone,
        codeName: response.codeName,
        playerGroup: response.playerGroup,
      });
    });
    */
   this.router.navigate(['player_creation']);
  }

  listPlayers(): void {
    this.playerService
    .listPlayers()
    .subscribe((val) => {
      this.players = val.content;
    });
  }

  ngOnInit(): void {
    this.listPlayers();
  }
}
