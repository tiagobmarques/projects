resource "aws_instance" "client-service" {
    count = 1 
    ami = "ami-09e67e426f25ce0d7"//This is a AMI with Ubuntu Server 20.04 LTS
    instance_type = "t2.micro" 
    key_name = "tax-teste" 
    tags = {
        Name = "card-insurance-client-service"
        //Name = "tax-client-service${count.index}"
    }
    vpc_security_group_ids = ["${aws_security_group.java-service-sg.id}"]
    private_ip = "10.0.16.13"
    subnet_id  = aws_subnet.subnet-tax-az-1a.id

    user_data = "${file("configure_client_service.sh")}"
}