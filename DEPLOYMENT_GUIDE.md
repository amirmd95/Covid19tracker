# Deployment Guide - COVID-19 Tracker

## 🚀 Free Deployment Options

This guide will help you deploy your COVID-19 Tracker to free hosting platforms.

---

## Option 1: Deploy to Vercel (Frontend) + Render (Backend) ⭐ RECOMMENDED

### Backend Deployment (Render.com - Free Tier)

**Step 1: Prepare Backend for Deployment**

Already configured! The `application.properties` is ready.

**Step 2: Deploy to Render**

1. Go to [render.com](https://render.com) and sign up (free)
2. Click "New +" → "Web Service"
3. Connect your GitHub repository or use "Public Git Repository"
4. If using public repo, enter: `https://github.com/yourusername/Covid19tracker`
5. Configure:
   - **Name**: `covid19-tracker-backend`
   - **Region**: Choose closest to you
   - **Branch**: `main`
   - **Root Directory**: `backend`
   - **Runtime**: `Java`
   - **Build Command**: `mvn clean install -DskipTests`
   - **Start Command**: `java -jar target/covid19-tracker-1.0.0.jar`
   - **Instance Type**: `Free`

6. Click "Create Web Service"

**Your backend will be deployed at**: `https://covid19-tracker-backend.onrender.com`

---

### Frontend Deployment (Vercel - Free Tier)

**Step 1: Update Environment for Production**

Update `frontend/src/environments/environment.prod.ts`:
```typescript
export const environment = {
  production: true,
  apiUrl: 'https://covid19-tracker-backend.onrender.com/api/covid19'
};
```

**Step 2: Deploy to Vercel**

1. Go to [vercel.com](https://vercel.com) and sign up (free)
2. Click "Add New..." → "Project"
3. Import your GitHub repository
4. Configure:
   - **Framework Preset**: Angular
   - **Root Directory**: `frontend`
   - **Build Command**: `npm run build`
   - **Output Directory**: `dist/covid19-tracker-frontend/browser`
   - **Install Command**: `npm install`

5. Click "Deploy"

**Your frontend will be deployed at**: `https://covid19-tracker.vercel.app`

---

## Option 2: All-in-One with Railway.app

**Free Tier**: $5/month credit (enough for small apps)

1. Go to [railway.app](https://railway.app) and sign up
2. Create new project
3. Deploy from GitHub repo
4. Railway will auto-detect Spring Boot and Angular
5. Set environment variables if needed

---

## Option 3: Netlify (Frontend) + Railway (Backend)

### Frontend on Netlify

1. Go to [netlify.com](https://netlify.com) and sign up
2. Drag and drop your `frontend/dist` folder after building
3. Or connect GitHub repository
4. Configure:
   - **Build command**: `npm run build`
   - **Publish directory**: `dist/covid19-tracker-frontend/browser`
   - **Base directory**: `frontend`

### Backend on Railway

Same as Option 2 for backend only.

---

## 📋 Pre-Deployment Checklist

### Backend
- ✅ `application.properties` configured for H2 (no external DB needed)
- ✅ CORS configured to allow frontend domain
- ✅ JAR file builds successfully
- ⚠️ Update CORS after deployment with frontend URL

### Frontend
- ✅ All components created
- ✅ Environment files configured
- ⚠️ Update `environment.prod.ts` with backend URL
- ✅ Production build works

---

## 🔧 Post-Deployment Configuration

### Update CORS (Important!)

After deploying frontend, update backend CORS:

**File**: `backend/src/main/resources/application.properties`

```properties
cors.allowed.origins=https://your-frontend.vercel.app,http://localhost:4200
```

Redeploy backend after this change.

---

## 🌐 Final URLs

After deployment, you'll have:

- **Frontend**: `https://covid19-tracker.vercel.app` (or your custom domain)
- **Backend API**: `https://covid19-tracker-backend.onrender.com/api/covid19`

Share the frontend URL with anyone! 🎉

---

## 💡 Cost Breakdown

| Service | Cost | Limits |
|---------|------|--------|
| **Vercel** | Free Forever | 100GB bandwidth/month |
| **Render** | Free Forever | 750 hours/month, sleeps after 15 min inactivity |
| **Netlify** | Free Forever | 100GB bandwidth/month |
| **Railway** | $5 credit/month | Pay as you go after credit |

---

## ⚠️ Important Notes

### Render Free Tier Limitations
- **Sleeps after 15 minutes of inactivity**
- First request after sleep takes 30-60 seconds to wake up
- Perfect for demo/portfolio projects
- Upgrade to paid ($7/month) for always-on service

### Solutions for Sleep Issue
1. Use **Render Cron Jobs** (free) to ping every 14 minutes
2. Use external uptime monitor (like UptimeRobot)
3. Upgrade to paid tier

---

## 🚀 Quick Deploy Commands

### Build Frontend for Production
```bash
cd frontend
npm run build
# Output: dist/covid19-tracker-frontend/browser/
```

### Build Backend JAR
```bash
cd backend
mvn clean package
# Output: target/covid19-tracker-1.0.0.jar
```

---

## 📱 Mobile Responsive

The application is already mobile-responsive and will work perfectly on phones and tablets!

---

## 🎯 Next Steps

1. Push your code to GitHub
2. Deploy backend to Render
3. Update frontend environment with backend URL
4. Deploy frontend to Vercel
5. Share your live link! 🎉

**Estimated deployment time**: 15-20 minutes

---

## 🆘 Troubleshooting

### Backend won't start on Render
- Check Java version is 17
- Verify `pom.xml` has correct Spring Boot version
- Check Render logs for errors

### Frontend can't connect to backend
- Verify CORS is configured with frontend URL
- Check `environment.prod.ts` has correct backend URL
- Ensure backend is awake (visit backend URL first)

### Build fails
- Clear cache and rebuild
- Check all dependencies are in `package.json` and `pom.xml`

---

## 📞 Support

Check deployment logs on respective platforms:
- Render: Dashboard → Your Service → Logs
- Vercel: Dashboard → Your Project → Deployments → Logs

---

**Ready to deploy? Follow the steps above and your COVID-19 Tracker will be live!** 🌍🦠📊

