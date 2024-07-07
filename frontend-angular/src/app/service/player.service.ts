import { Injectable } from '@angular/core';
import { Player } from '../model/player';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, catchError, map, Observable, throwError } from 'rxjs';
import { api } from '../utils/api';

interface IPlayerService {
  registerPlayer(data: any): Observable<Player>;
  listPlayers(): Observable<Player[]>;
  deletePlayerById(id: string): Observable<void>;
  updatePlayer(id: string, player: Player): Observable<Player>;
}

@Injectable({
  providedIn: 'root',
})
export class PlayerService implements IPlayerService {
  private url: string = api.development;

  constructor(private http: HttpClient) {}

  registerPlayer(data: any): Observable<Player> {
    return this.http.post<any>(`${this.url}/api/players/register-player`, data);
  }

  listPlayers(): Observable<Player[]> {
    return this.http
      .get<any>(`${this.url}/api/players/list-players`)
      .pipe(map((res) => res.content));
  }

  deletePlayerById(id: string): Observable<void> {
    return this.http.delete<void>(
      `${this.url}/api/players/delete-player-by-id?id=${id}`
    );
  }

  updatePlayer(id: string, player: Player): Observable<Player> {
    throw new Error('Method not implemented.');
  }
}
