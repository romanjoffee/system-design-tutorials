terraform {
  required_version = "~> 0.13"
  required_providers {
    aws = ">= 2.61"
  }
}

locals {
  private_ips        = ["172.17.17.17", "172.17.17.18", "172.17.17.19"]
  instance_types     = ["t3.large", "t3.large", "t3.medium"]
  subnet_ids         = ["subnet-0574167df", "subnet-0574167df", "subnet-948573ch"]
  security_group_ids = [["sg-02e500k1", "sg-11e600k1"],
                        ["sg-02e500k1", "sg-11e600k1"],
                        ["sg-3993h", "sg-3993h"]
  ]
  amis               = ["ami-128fk", "ami-128fk", "ami-228ck"]
}

resource "aws_instance" "node" {
  count = length(local.private_ips)

  instance_type          = element(local.instance_types, count.index)
  private_ip             = element(local.private_ips, count.index)
  subnet_id              = element(local.subnet_ids, count.index)
  ami                    = element(local.amis, count.index)
  vpc_security_group_ids = element(local.security_group_ids, count.index)
}

