locals {
  nodes = {
    "node-1" = {
      instance_type      = "t3.large"
      private_ip         = "172.17.17.17"
      subnet_id          = "subnet-0574167df"
      security_group_ids = ["sg-02e500k1", "sg-11e600k1"]
      ami                = "ami-128fk"

    }
    "node-2" = {
      instance_type      = "t3.large"
      private_ip         = "172.17.17.18"
      subnet_id          = "subnet-0574167df"
      security_group_ids = ["sg-02e500k1", "sg-11e600k1"]
      ami                = "ami-128fk"

    }
    "node-3" = {
      instance_type      = "t3.medium"
      private_ip         = "172.17.17.19"
      subnet_id          = "subnet-948573ch"
      security_group_ids = ["sg-3993h", "sg-3993h"]
      ami                = "ami-228ck"
    }
  }
}

resource "aws_instance" "node" {
  for_each = local.nodes

  instance_type          = each.value.instance_type
  private_ip             = each.value.private_ip
  subnet_id              = each.value.subnet_id
  ami                    = each.value.ami
  vpc_security_group_ids = each.value.security_group_ids
}
