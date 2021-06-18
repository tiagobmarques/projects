resource "aws_s3_bucket" "lambda-jar-storage" {
  bucket = "tax-lambda-jar-storage"
  acl    = "private"
  force_destroy = true

  tags = {
    Name        = "Tax-Calculate"
    Environment = "Dev"
  }
}

resource "aws_s3_bucket_object" "object" {
  bucket = aws_s3_bucket.lambda-jar-storage.id
  key    = "tax-0.0.1-SNAPSHOT.zip"
  acl    = "private"  # or can be "public-read"
  source = "tax-0.0.1-SNAPSHOT.zip"
  etag = filemd5("tax-0.0.1-SNAPSHOT.zip")
}