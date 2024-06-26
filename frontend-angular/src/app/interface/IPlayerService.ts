import { Player } from "../model/player";

export interface IPlayerService {
  listPlayer(): Player[];
}
