resource "aws_db_subnet_group" "dbsp_tax" {
  name       = "db-subnet-group-tax"
  subnet_ids = [aws_subnet.subnet-tax-az-1a.id, aws_subnet.subnet-tax-az-1b.id]

  tags = {
    Name = "My DB subnet group for Tax"
  }
}

resource "aws_db_instance" "db_tax" {
  allocated_storage    = 20
  storage_type         = "standard"
  engine               = "postgres"
  engine_version       = "12.4"
  instance_class       = "db.t3.micro"
  name                 = "cardInsuranceDBInstance"
  username             = "postgres"
  password             = "password"
  identifier           = "card-insurance-db"
  vpc_security_group_ids = ["${aws_security_group.postgres-sg.id}"] 
  publicly_accessible = true
  db_subnet_group_name = aws_db_subnet_group.dbsp_tax.id
  final_snapshot_identifier = false
  skip_final_snapshot  = true
}