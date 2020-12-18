# Intent

Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon
receiving a com.babkamen.game_example.be_example.request, each com.babkamen.game_example.be_example.handler decides either to process the com.babkamen.game_example.be_example.request or to pass it
to the next com.babkamen.game_example.be_example.handler in the chain.

# Applicability

- Use the Chain of Responsibility pattern when your program is expected to process different kinds of requests in
  various ways, but the exact types of requests and their sequences are unknown beforehand.
- Use the pattern when it’s essential to execute several handlers in a particular order.
- Use the CoR pattern when the set of handlers and their order are supposed to change at runtime.