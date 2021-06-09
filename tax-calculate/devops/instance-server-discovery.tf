resource "aws_instance" "server-discovery" {
    count = 1 
    ami = "ami-0c79c59cf34515d65"//This is a AMI for Internal services, ex: Java
    instance_type = "t2.micro" 
    key_name = "tax-teste" 
    tags = {
        Name = "tax-server-discovery"
        //Name = "tax-server-discovery${count.index}"
    }
    vpc_security_group_ids = ["${aws_security_group.server-discovery-sg.id}"]
    private_ip = "10.0.16.12"
    subnet_id  = aws_subnet.subnet-tax-az-1a.id
}