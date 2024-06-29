import { PlayerGroup } from './playerGroup.enum';

export class Player {
  id: string | null;
  name: string | null;
  email: string | null;
  phone: string | null;
  codeName: string | null;
  playerGroup: PlayerGroup | null;

  constructor(
    id: string | null,
    name: string | null,
    email: string | null,
    phone: string | null,
    codeName: string | null,
    playerGroup: PlayerGroup | null
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.codeName = codeName;
    this.playerGroup = playerGroup;
  }
}
