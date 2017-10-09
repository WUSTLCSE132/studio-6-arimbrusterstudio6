const int buttonPin = 2;
int buttonPushes = 0;

void buttonPressed() {
  Serial.println("Interrupt");
  buttonPushes += 1;
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.  
  // Three edge types are supported: CHANGE, RISING, and FALLING 
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, FALLING);
  Serial.begin(9600);
}

void loop() {
  for(int i=0;i<100;i++) {
    Serial.println(buttonPushes);
    delay(1000);
  }
}
