import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-player-update',
  standalone: true,
  imports: [],
  templateUrl: './player-update.component.html',
  styleUrl: './player-update.component.scss',
})
export class PlayerUpdateComponent {
  value: string = 'test';

  constructor(
    private activatedRoute: ActivatedRoute
  ) {}

  getValue() {
    //return this.value = this.activatedRoute
    //  .snapshot
    //  .queryParamMap
    //  .get('id')!;
  }
}
