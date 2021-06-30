#############################
# DynamoDB
#############################
resource "aws_dynamodb_table" "main-table" {
  name           = var.table-name
  billing_mode   = "PROVISIONED"
  read_capacity  = 2
  write_capacity = 2
  hash_key       = "employeeId"
  stream_enabled   = true
  stream_view_type = "NEW_IMAGE"

  attribute {
    name = "employeeId"
    type = "S"
  }

  tags = {
    Name        = "${var.table-name}-${var.environment}"
    Environment = var.environment
  }
}