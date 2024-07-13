import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PlayerService } from '../../service/player.service';
import { 
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-player-update',
  standalone: true,
  imports: [],
  templateUrl: './player-update.component.html',
  styleUrl: './player-update.component.scss',
})
export class PlayerUpdateComponent {
  value: string = 'test';
  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  constructor(
    private activatedRoute: ActivatedRoute,
    private playerService: PlayerService,
    private snackBar: MatSnackBar,
  ) {
    this.getPlayerById()
  }

  getPlayerById() {
    const id = this.activatedRoute
      .snapshot
      .queryParamMap
      .get('id')!;

    this.playerService.getPlayerById(id)
      .pipe(
        catchError((err) => {
          return throwError(() => {
            this.showMessage(err.error.message);
          });
        })
      )
      .subscribe((res) => this.value = res.phone!);
  }

  private showMessage(message: string) {
    this.snackBar.open(`${message}`, 'Splash', {
      duration: 3000,
    });
  }
}
