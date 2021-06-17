resource "aws_lambda_function" "tax-lambda" {
  function_name = "tax-lambda"
  role          = "arn:aws:iam::062640588266:role/sqslambda"
  handler       = "com.bmarques.tax.UpperCaseStringHandler::handleRequest"

  s3_bucket         = "tax-lambda-jar-storage"
  s3_key            = "tax-0.0.1-SNAPSHOT.zip"

  runtime = "java11"

  depends_on = [aws_s3_bucket.lambda-jar-storage, aws_sqs_queue.sqs-queue]

  environment {
    variables = {
      foo = "bar"
    }
  }
}

# Event source from SQS
resource "aws_lambda_event_source_mapping" "event_source_mapping" {
  event_source_arn = "${aws_sqs_queue.sqs-queue.arn}"
  enabled          = true
  function_name    = "${aws_lambda_function.tax-lambda.arn}"
  batch_size       = 1
}