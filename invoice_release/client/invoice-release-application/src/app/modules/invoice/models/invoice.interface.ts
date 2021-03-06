export interface IInvoice {
  id: number,
  installmentDate: Date
  document: String
  participantId: number
  value: number
}

export interface IInvoiceList {
  id: number,
  installmentDate: Date
  document: String
  participantId: number
  participantName: number
  value: number
}
