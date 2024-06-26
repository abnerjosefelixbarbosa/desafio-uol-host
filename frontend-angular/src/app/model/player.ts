import { IPlayer } from '../interface/IPlayer';

export class Player implements IPlayer {
  id: string;
  name: string;

  constructor(id: string, name: string) {
    this.id = id;
    this.name = name;
  }
}
