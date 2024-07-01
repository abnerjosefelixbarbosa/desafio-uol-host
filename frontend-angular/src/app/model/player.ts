import { PlayerGroup } from './playerGroup.enum';

export interface Player {
  id: string | null;
  name: string | null;
  email: string | null;
  phone: string | null;
  codeName: string | null;
  playerGroup: PlayerGroup | null;
}