resource "aws_dynamodb_table" "basic-dynamodb-table" {
  name           = "invoice"
  billing_mode   = "PROVISIONED"
  read_capacity  = 20
  write_capacity = 20
  hash_key       = "invoiceId"

  attribute {
    name = "invoiceId"
    type = "S"
  }

  ttl {
    attribute_name = "TimeToExist"
    enabled        = false
  }

  tags = {
    Name        = "dynamodb-table-invoice"
  }
}