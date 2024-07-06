import { Injectable } from '@angular/core';
import { Player } from '../model/player';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, catchError, map, Observable, throwError } from 'rxjs';
import { api } from '../utils/api';

export interface IPlayerService {
  registerPlayer(data: any): Observable<Player>;
  listPlayers(): Observable<Player[]>;
  deletePlayerById(id: string): Observable<void>;
  updatePlayer(id: string, player: Player): Observable<any>;
}

@Injectable({
  providedIn: 'root',
})
export class PlayerService implements IPlayerService {
  private api: string = api.development;
  private cache: BehaviorSubject<any> = new BehaviorSubject(null);

  constructor(private http: HttpClient) {}

  registerPlayer(data: any): Observable<Player> {
    return this.http
      .post<any>(`${this.api}/api/players/register-player`, data)
      .pipe(map((res) => res));
  }

  listPlayers(): Observable<Player[]> {
    if (this.cache.getValue() !== null) {
      return new Observable<any>((val) => {
        val.next(this.cache.getValue());
      }) 
    }  
    

    return this.http.get<any>(`${this.api}/api/players/list-players`).pipe(
      map((res) => {
        this.cache.next(res.content);
        return this.cache.getValue();
      })
    );
  }

  deletePlayerById(id: string): Observable<void> {
    throw new Error('Method not implemented.');
  }

  updatePlayer(id: string, player: Player): Observable<any> {
    throw new Error('Method not implemented.');
  }
}
