# Demo data for screenshots

`Dockerfile` — `old-builder` is never referenced (flagged),
`node-builder` is referenced by the final stage (not flagged).

## How to get the screenshot

1. `./gradlew runIde` from `dockerfile-unused-stage-companion`, open
   this `demo/` folder as the project.
2. Full Screen, open `Dockerfile` — a warning should appear on the
   `old-builder` line only.
3. Screenshot with all stages visible, save into
   `dockerfile-unused-stage-companion/docs/screenshots/`. Close the
   sandbox.
