import { PlayerGroup } from "./playerGroup.enum";

export interface Player {
  id: String | null;
  name: String | null;
  email: String | null;
  phone: String | null;
  codeName: String | null;
  playerGroup: PlayerGroup | null;
}