locals {
  nodes = {
    "node-1" = {
      private_ip = "172.17.17.17"
    }
    "node-2" = {
      private_ip = "172.17.17.18"
    }
    "node-3" = {
      instance_type      = "t3.medium"
      private_ip         = "172.17.17.19"
      subnet_id          = "subnet-948573ch"
      security_group_ids = ["sg-3993h", "sg-3993h"]
      ami                = "ami-228ck"
    }
  }

  default_instance_type      = "t3.large"
  default_subnet_id          = "subnet-0574167df"
  default_security_group_ids = ["sg-02e500k1", "sg-11e600k1"]
  default_ami                = "ami-128fk"
}

resource "aws_instance" "node" {
  for_each = local.nodes

  private_ip             = each.value.private_ip
  instance_type          = try(each.value.instance_type, local.default_instance_type)
  subnet_id              = try(each.value.subnet_id, local.default_subnet_id)
  ami                    = try(each.value.ami, local.default_ami)
  vpc_security_group_ids = try(each.value.security_group_ids, local.default_security_group_ids)
}