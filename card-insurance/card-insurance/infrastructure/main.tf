#############################
# DynamoDB
#############################
resource "aws_dynamodb_table" "coverage-table" {
  name           = "coverage"
  billing_mode   = "PROVISIONED"
  read_capacity  = 2
  write_capacity = 2
  hash_key       = "coverageId"
  stream_enabled   = true
  stream_view_type = "NEW_IMAGE"

  attribute {
    name = "coverageId"
    type = "S"
  }

  tags = {
    Name        = "coverage-${var.environment}"
    Environment = "coverage"
  }
}