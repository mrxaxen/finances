import { User } from './user';

export class Transaction {
    id: number = 0;
    title: string = '';
    change: number = 0;
    creationDate: Date;
    user:User;
    month:string;
  }
  