const int buttonPin = 2;
const int debounceDelay = 50;

unsigned long lastDebounceTime = 0;
unsigned long now = millis();

int buttonPushes = 0;

void buttonPressed() {
  now = millis();
  if (now >= lastDebounceTime) {
    lastDebounceTime = now + debounceDelay;
    buttonPushes += 1;
    Serial.println("Button Pushed");
  }
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, RISING);
  Serial.begin(9600);
}

void loop() {
  for(int i=0;i<100;i++) {
    Serial.println(buttonPushes);
    delay(1000);
  }
}

