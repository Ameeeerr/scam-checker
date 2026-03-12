# Scam Link Checker

A full stack web application that analyzes URLs for security threats using Google's Safe Browsing API.

## Live Demo
[scam-checker-five.vercel.app](https://scam-checker-five.vercel.app)

## Tech Stack
- Backend: Java 21, Spring Boot 4.0
- Frontend: HTML, CSS, JavaScript
- Security: Google Safe Browsing API
- Deployment: Railway (backend), Vercel (frontend)

## Features
- Paste any URL and get an instant safety analysis
- Detects malware, phishing sites, and unwanted software
- Returns clear SAFE or DANGEROUS result

## How to Run Locally
1. Clone the repo
2. Get a free Google Safe Browsing API key from console.developers.google.com
3. In IntelliJ, set environment variable: SAFE_BROWSING_API_KEY=your-key
4. Run the app through IntelliJ Maven panel
5. Open frontend/index.html in your browser
