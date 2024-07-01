import { Injectable } from '@angular/core';
import { Player } from '../model/player';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environments';

export interface IPlayerService {
  registerPlayer(data: any): Observable<any>;
  listPlayers(): Observable<any>;
  deletePlayerById(id: string): void;
  updatePlayer(id: string, player: Player): Player;
}

@Injectable({
  providedIn: 'root',
})
export class PlayerService implements IPlayerService {
  private url: string = environment.development_api;

  constructor(private http: HttpClient) {}

  registerPlayer(data: any): Observable<any> {
    return this.http.post<any>(`${this.url}/api/players/register-player`, data);
  }

  listPlayers(): Observable<any> {
    return this.http.get<any>(`${this.url}/api/players/list-players`);
  }

  deletePlayerById(id: string): void {
    throw new Error('Method not implemented.');
  }

  updatePlayer(id: string, player: Player): Player {
    throw new Error('Method not implemented.');
  }
}
