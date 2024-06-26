import { Injectable } from '@angular/core';
import { IPlayerService } from '../interface/IPlayerService';
import { Player } from '../model/player';

@Injectable({
  providedIn: 'root',
})
export class PlayerService implements IPlayerService {
  players: Player[] = [{ id: '1', name: 'name1' }];

  constructor() {}

  listPlayer(): Player[] {
    return this.players;
  }
}
