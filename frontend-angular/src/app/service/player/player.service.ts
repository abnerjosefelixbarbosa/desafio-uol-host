import { Injectable } from '@angular/core';
import { Player } from '../../model/player';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { api } from '../../utils/api';

export interface IPlayerService {
  registerPlayer(data: any): Observable<any>;
  listPlayers(): Observable<any>;
  deletePlayerById(id: string): Observable<void>;
  updatePlayer(id: string, player: Player): Observable<any>;
}

@Injectable({
  providedIn: 'root',
})
export class PlayerService implements IPlayerService {
  private api: string = api.development;

  constructor(private http: HttpClient) {}

  registerPlayer(data: any): Observable<any> {
    return this.http.post<any>(`${this.api}/api/players/register-player`, data);
  }

  listPlayers(): Observable<any> {
    return this.http.get<any>(`${this.api}/api/players/list-players`);
  }

  deletePlayerById(id: string): Observable<void> {
    throw new Error('Method not implemented.');
  }

  updatePlayer(id: string, player: Player): Observable<any> {
    throw new Error('Method not implemented.');
  }
}
