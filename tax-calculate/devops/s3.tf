resource "aws_s3_bucket" "lambda-jar-storage" {
  bucket = "tax-lambda-jar-storage"
  acl    = "private"
  force_destroy = true

  tags = {
    Name        = "Tax-Calculate"
    Environment = "Dev"
  }
}