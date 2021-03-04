import { IParticipant } from './../../participant/models/participant.interface';

export interface IInvoice {
  id: number,
  installmentDate: Date
  document: String
  participant: IParticipant
  value: number
}
