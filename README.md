# Scam Link Checker

A full stack web app that checks if a URL is safe or dangerous using Google's Safe Browsing API.

## Live Demo
[scam-checker-five.vercel.app](https://scam-checker-five.vercel.app)

## Tech Stack
- Backend: Java, Spring Boot, REST API
- Frontend: HTML, CSS, JavaScript
- API: Google Safe Browsing
- Deployment: Railway (backend), Vercel (frontend)

## Features
- Paste any suspicious URL and get instant results
- Detects malware, phishing, and unwanted software
- Clean, responsive UI

## How to Run Locally
1. Clone the repo
2. Get a free Google Safe Browsing API key from Google Cloud Console
3. Set environment variable: SAFE_BROWSING_API_KEY=your-key
4. Run: ./mvnw spring-boot:run
5. Open frontend/index.html in your browser
