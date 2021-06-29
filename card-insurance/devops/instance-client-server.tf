resource "aws_instance" "client-service" {
    count = 1 
    ami = "ami-0f8357bdf347cc9d8"//This is a AMI for Internal services, ex: Java
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