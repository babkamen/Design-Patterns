# Intent
Visitor is a behavioral design pattern that lets you separate algorithms from the objects on which they operate.
# Types

- Intrusive visitor(implementing print in evey class in hierarchy)
  Violates Single responsibility principle- Ref
- Reflective visitor(checking class on visit)
- Double dispatch visitor(Popular version)
- Acyclic visitor(When some classes don't need visitor)