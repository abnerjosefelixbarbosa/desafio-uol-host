import { Injectable } from '@angular/core';
import { Player } from '../model/player';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface IPlayerService {
  registerPlayer(player: Player): Observable<any>;
  listPlayers(): Observable<any>;
  deletePlayerById(id: string): void;
  updatePlayer(id: string, player: Player): Player;
}

@Injectable({
  providedIn: 'root',
})
export class PlayerService implements IPlayerService {
  private url = 'http://localhost:8080/api/players';

  constructor(private http: HttpClient) {
  }

  registerPlayer(player: any): Observable<any> {
    return this.http.post<any>(`${this.url}/register-players`, player)
  }

  listPlayers(): Observable<any> {
    return this.http.get<any>(`${this.url}/list-players`);
  }

  deletePlayerById(id: string): void {
    throw new Error('Method not implemented.');
  }

  updatePlayer(id: string, player: Player): Player {
    throw new Error('Method not implemented.');
  }
}