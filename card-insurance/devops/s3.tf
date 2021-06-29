
resource "aws_s3_bucket" "card-insurance-storage" {
  bucket = "card-insurance-storage"
  acl    = "public-read"
  force_destroy = true

  tags = {
    Name        = "Card Insurance"
    Environment = "Dev"
  }
}