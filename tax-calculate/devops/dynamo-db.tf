resource "aws_dynamodb_table" "invoice-dynamodb-table" {
  name           = "invoice"
  billing_mode   = "PROVISIONED"
  read_capacity  = 20
  write_capacity = 20
  hash_key       = "invoiceId"

  attribute {
    name = "invoiceId"
    type = "S"
  }

  tags = {
    Name        = "dynamodb-table-invoice"
  }
}

resource "aws_dynamodb_table" "tax-dynamodb-table" {
  name           = "tax"
  billing_mode   = "PROVISIONED"
  read_capacity  = 20
  write_capacity = 20
  hash_key       = "taxId"

  attribute {
    name = "taxId"
    type = "S"
  }

  tags = {
    Name        = "dynamodb-table-tax"
  }
}