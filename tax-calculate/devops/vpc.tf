// VPC
resource "aws_vpc" "vpc-tax" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_hostnames = true
  
  tags = {
    Name = "vpc-tax"
  }
}

// VPC - Route table - Gateway
resource "aws_internet_gateway" "gw" {
  vpc_id = aws_vpc.vpc-tax.id

  tags = {
    Name = "igw-main"
  }
}

// VPC - Route table - Gateway
resource "aws_route_table" "rtb-tax" {
  vpc_id = aws_vpc.vpc-tax.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.gw.id
  }

  tags = {
    Name = "rtb-tax"
  }
}

resource "aws_main_route_table_association" "rtb-tax-main" {
  vpc_id         = aws_vpc.vpc-tax.id
  route_table_id = aws_route_table.rtb-tax.id
}

// VPC - NetWork ACL - Subnet
resource "aws_subnet" "subnet-tax-az-1a" {
  vpc_id                  = aws_vpc.vpc-tax.id
  cidr_block              = "10.0.16.0/20"
  map_public_ip_on_launch = true
  availability_zone       = "us-east-1a"

  tags = {
    Name = "subnet-tax-az-1a"
  }

  depends_on = [aws_internet_gateway.gw]
}

// VPC - NetWork ACL - Subnet
resource "aws_subnet" "subnet-tax-az-1b" {
  vpc_id                  = aws_vpc.vpc-tax.id
  cidr_block              = "10.0.32.0/20"
  map_public_ip_on_launch = true
  availability_zone       = "us-east-1b"

  tags = {
    Name = "subnet-tax-az-1b"
  }

  depends_on = [aws_internet_gateway.gw]
}