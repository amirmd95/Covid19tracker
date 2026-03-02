# ✅ DEPLOYMENT CHECKLIST - COVID-19 Tracker

Use this checklist to deploy your app step by step!

---

## 📋 PRE-DEPLOYMENT CHECKLIST

### Local Setup
- [ ] Backend builds successfully (`mvn clean install`)
- [ ] Backend runs locally (`mvn spring-boot:run`)
- [ ] Frontend builds successfully (`npm run build`)
- [ ] Frontend runs locally (`npm start`)
- [ ] App works on `http://localhost:4200`
- [ ] Dashboard shows COVID data
- [ ] Countries page works

### GitHub Setup
- [ ] Have GitHub account
- [ ] Code is in Git repository locally
- [ ] `.gitignore` is configured
- [ ] Ready to push to GitHub

---

## 🚀 DEPLOYMENT STEPS

### STEP 1: Push to GitHub
- [ ] Created repository on GitHub.com
- [ ] Initialized git locally (`git init`)
- [ ] Added all files (`git add .`)
- [ ] Created commit (`git commit -m "Initial commit"`)
- [ ] Added remote (`git remote add origin ...`)
- [ ] Pushed to GitHub (`git push -u origin main`)
- [ ] Verified files on GitHub.com

---

### STEP 2: Deploy Backend (Render)

#### Account Setup
- [ ] Signed up at [render.com](https://render.com)
- [ ] Connected GitHub account
- [ ] Verified email

#### Service Creation
- [ ] Clicked "New +" → "Web Service"
- [ ] Selected GitHub repository
- [ ] Configured settings:
  - [ ] Name: `covid19-tracker-backend`
  - [ ] Region: Selected closest
  - [ ] Branch: `main`
  - [ ] Root Directory: `backend`
  - [ ] Runtime: `Java`
  - [ ] Build Command: `mvn clean install -DskipTests`
  - [ ] Start Command: `java -jar target/covid19-tracker-1.0.0.jar`
  - [ ] Instance Type: `Free`

#### Deployment
- [ ] Clicked "Create Web Service"
- [ ] Waited for build (5-10 minutes)
- [ ] Build succeeded (green checkmark)
- [ ] Copied backend URL: `https://_________________.onrender.com`

#### Testing
- [ ] Opened backend URL in browser
- [ ] Waited for service to start (30-60 seconds)
- [ ] Tested: `https://YOUR_BACKEND_URL/actuator/health`
- [ ] Tested: `https://YOUR_BACKEND_URL/api/covid19/global`
- [ ] Both URLs return data ✅

---

### STEP 3: Update Frontend Environment

#### Edit Configuration
- [ ] Opened `frontend/src/environments/environment.prod.ts`
- [ ] Updated `apiUrl` with Render backend URL
- [ ] Saved file

#### Push Changes
- [ ] `git add frontend/src/environments/environment.prod.ts`
- [ ] `git commit -m "Update production API URL"`
- [ ] `git push`
- [ ] Verified changes on GitHub

---

### STEP 4: Deploy Frontend (Vercel)

#### Account Setup
- [ ] Signed up at [vercel.com](https://vercel.com)
- [ ] Connected GitHub account
- [ ] Verified email

#### Project Creation
- [ ] Clicked "Add New..." → "Project"
- [ ] Imported GitHub repository
- [ ] Configured settings:
  - [ ] Framework Preset: `Angular`
  - [ ] Root Directory: `frontend`
  - [ ] Build Command: `npm run build`
  - [ ] Output Directory: `dist/covid19-tracker-frontend/browser`
  - [ ] Install Command: `npm install`

#### Deployment
- [ ] Clicked "Deploy"
- [ ] Waited for build (3-5 minutes)
- [ ] Build succeeded
- [ ] Copied frontend URL: `https://_________________.vercel.app`

---

### STEP 5: Final Testing

#### Frontend Testing
- [ ] Opened Vercel URL in browser
- [ ] Page loads without errors
- [ ] Dashboard shows COVID-19 statistics
- [ ] All 6 stat cards display data
- [ ] "Refresh Data" button works

#### Countries Page Testing
- [ ] Clicked "Countries" in navigation
- [ ] Countries table loads with data
- [ ] Country flags appear
- [ ] Search box works
- [ ] Sorting columns works

#### Cross-Browser Testing
- [ ] Tested in Chrome
- [ ] Tested in Firefox
- [ ] Tested in Safari

#### Mobile Testing
- [ ] Tested on mobile device or responsive mode
- [ ] Layout is responsive
- [ ] All features work

---

## 🎉 POST-DEPLOYMENT

### Share Your Link!
- [ ] Copied Vercel URL
- [ ] Shared with friends/family
- [ ] Added to resume/portfolio
- [ ] Posted on LinkedIn/Twitter (optional)

### Optional: Custom Domain
- [ ] Purchased domain (optional)
- [ ] Added to Vercel
- [ ] Configured DNS
- [ ] SSL certificate generated

### Optional: Keep Backend Awake
- [ ] Signed up at [uptimerobot.com](https://uptimerobot.com)
- [ ] Added backend URL monitor
- [ ] Set interval to 14 minutes
- [ ] Backend stays awake ✅

---

## 🔧 TROUBLESHOOTING CHECKLIST

### Backend Issues
- [ ] Checked Render logs
- [ ] Verified Java 17 is being used
- [ ] Checked build command is correct
- [ ] Verified JAR file is created
- [ ] Tested health endpoint
- [ ] Checked for CORS errors

### Frontend Issues
- [ ] Checked Vercel build logs
- [ ] Verified Node 18 is being used
- [ ] Checked build command is correct
- [ ] Verified output directory path
- [ ] Checked environment.prod.ts has correct URL
- [ ] Opened browser console for errors

### Connection Issues
- [ ] Backend is awake and running
- [ ] Frontend has correct backend URL
- [ ] CORS is configured correctly
- [ ] No network errors in console

---

## 📊 VERIFICATION CHECKLIST

### Backend Verification
- [ ] `https://YOUR_BACKEND/actuator/health` returns `{"status":"UP"}`
- [ ] `https://YOUR_BACKEND/api/covid19/global` returns COVID data
- [ ] `https://YOUR_BACKEND/api/covid19/countries` returns array of countries
- [ ] No CORS errors in browser console

### Frontend Verification
- [ ] Homepage loads
- [ ] Dashboard shows 6 statistics cards
- [ ] All numbers are formatted correctly
- [ ] "Last updated" timestamp appears
- [ ] Countries page loads
- [ ] Search functionality works
- [ ] Sorting functionality works
- [ ] Mobile responsive design works

---

## 🎯 FINAL CHECKLIST

- [ ] Both backend and frontend are deployed
- [ ] All features work correctly
- [ ] No console errors
- [ ] Tested on multiple browsers
- [ ] Tested on mobile device
- [ ] Performance is acceptable
- [ ] Ready to share! 🎉

---

## 📝 DEPLOYMENT INFORMATION

### Your URLs

**Frontend (Share This!)**:
```
https://________________________________.vercel.app
```

**Backend API**:
```
https://________________________________.onrender.com
```

### Deployment Dates
- **Initial Deployment**: _______________
- **Last Update**: _______________

### Platforms Used
- [ ] Render (Backend)
- [ ] Vercel (Frontend)
- [ ] GitHub (Source Code)
- [ ] UptimeRobot (Keep Awake) - Optional

---

## 🎊 CONGRATULATIONS!

If all checkboxes are checked, you have successfully deployed your COVID-19 Tracker!

**Share your link**: ______________________________________

**Added to portfolio**: [ ] Yes [ ] No

**Shared with others**: [ ] Yes [ ] No

---

## 📌 NOTES

Use this space for notes:

```
Backend URL: 

Frontend URL: 

Custom Domain: 

Issues Encountered:


Solutions:


Next Steps:


```

---

**Deployment completed**: [ ] Yes!

**Ready to share with the world**: [ ] Absolutely! 🚀

---

*Save this checklist for future reference and updates!*

