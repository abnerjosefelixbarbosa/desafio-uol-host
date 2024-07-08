import { Routes } from '@angular/router';
import { PlayerListComponent } from './pages/player-list/player-list.component';
import { PlayerCreationComponent } from './pages/player-creation/player-creation.component';
import { PlayerUpdateComponent } from './pages/player-update/player-update.component';

export const routes: Routes = [
  {
    path: '',
    component: PlayerListComponent,
  },
  {
    path: 'player_creation',
    component: PlayerCreationComponent,
  },
  {
    path: 'player_update',
    component: PlayerUpdateComponent,
  },
];
