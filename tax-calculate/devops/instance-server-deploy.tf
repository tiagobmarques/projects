resource "aws_instance" "server-deploy" {
    count = 1 
    ami = "ami-0f79f579900228d13"//This is Jenkins AMI 
    instance_type = "t2.medium" 
    key_name = "tax-teste" 

    tags = {
        Name = "tax-devops-server-deploy"
        //Name = "tax-devops-server-deploy${count.index}"
    }
    
    vpc_security_group_ids = ["${aws_security_group.server-deploy-sg.id}"]
    private_ip = "10.0.16.15"
    subnet_id  = aws_subnet.subnet-tax-az-1a.id
}