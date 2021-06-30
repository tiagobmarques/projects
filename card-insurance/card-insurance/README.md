### Prerequisites
* Docker
* Terraform
* AWS CLI

### How to run the application locally
First thing first, fire up localstack.

```
docker-compose up
```

Let’s deploy this Terraform configuration.
```
cd infrastructure
terraform init
terraform plan -out="card-insurance-local"
```

If you get a similar output as the command above, go ahead and issue the command below
```
cd infrastructure
terraform apply -auto-approve card-insurance-local
```

If you got the following output (see below), then you did everything correctly.
```
aws dynamodb list-tables --endpoint-url http://localhost:4566
```

To clean up, simply use Terraform and provide the command below.
```
cd infrastructure
terraform destroy -auto-approve
```