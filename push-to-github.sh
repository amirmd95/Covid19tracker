#!/bin/bash

echo "╔═══════════════════════════════════════════════════════════════╗"
echo "║          COVID-19 TRACKER - PUSH TO GITHUB HELPER             ║"
echo "╚═══════════════════════════════════════════════════════════════╝"
echo ""

# Check if we're in the right directory
if [ ! -d "backend" ] || [ ! -d "frontend" ]; then
    echo "❌ Error: Please run this script from the Covid19tracker directory"
    exit 1
fi

echo "✅ Repository already initialized and committed!"
echo ""
echo "Current git status:"
git status
echo ""

# Check if remote exists
if git remote | grep -q origin; then
    echo "⚠️  Remote 'origin' already exists:"
    git remote -v
    echo ""
    read -p "Do you want to remove it and add a new one? (y/N): " response
    if [[ "$response" =~ ^[Yy]$ ]]; then
        git remote remove origin
        echo "✅ Removed existing remote"
    fi
fi

# Ask for GitHub username
echo ""
echo "📝 GitHub Repository Setup"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""
read -p "Enter your GitHub username: " github_username

if [ -z "$github_username" ]; then
    echo "❌ Username cannot be empty"
    exit 1
fi

# Repository name
repo_name="Covid19tracker"
read -p "Repository name (default: Covid19tracker): " custom_repo_name
if [ ! -z "$custom_repo_name" ]; then
    repo_name="$custom_repo_name"
fi

# Add remote
remote_url="https://github.com/$github_username/$repo_name.git"
echo ""
echo "🔗 Adding remote: $remote_url"
git remote add origin "$remote_url"

if [ $? -eq 0 ]; then
    echo "✅ Remote added successfully!"
else
    echo "❌ Failed to add remote"
    exit 1
fi

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "🚀 Ready to Push!"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""
echo "⚠️  IMPORTANT: Before pushing, make sure you have:"
echo "   1. Created repository on GitHub: $remote_url"
echo "   2. Generated a Personal Access Token (if using HTTPS)"
echo ""
read -p "Have you created the repository on GitHub? (y/N): " created

if [[ ! "$created" =~ ^[Yy]$ ]]; then
    echo ""
    echo "📖 Create repository first:"
    echo "   1. Go to: https://github.com/new"
    echo "   2. Repository name: $repo_name"
    echo "   3. Description: Full-stack COVID-19 tracker with Angular & Spring Boot"
    echo "   4. Public or Private (your choice)"
    echo "   5. DO NOT initialize with README"
    echo "   6. Click 'Create repository'"
    echo ""
    echo "Then run this script again or use this command:"
    echo "   git push -u origin main"
    exit 0
fi

echo ""
read -p "Push to GitHub now? (y/N): " push_now

if [[ "$push_now" =~ ^[Yy]$ ]]; then
    echo ""
    echo "🚀 Pushing to GitHub..."
    echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
    echo ""
    echo "⚠️  When prompted for password, use your Personal Access Token!"
    echo ""
    git push -u origin main

    if [ $? -eq 0 ]; then
        echo ""
        echo "╔═══════════════════════════════════════════════════════════════╗"
        echo "║                    ✅ SUCCESS! ✅                              ║"
        echo "╚═══════════════════════════════════════════════════════════════╝"
        echo ""
        echo "🎉 Your code is now on GitHub!"
        echo ""
        echo "📍 Repository URL:"
        echo "   https://github.com/$github_username/$repo_name"
        echo ""
        echo "🚀 Next Steps:"
        echo "   1. Visit your repository on GitHub"
        echo "   2. Verify all files are there"
        echo "   3. Read DEPLOY_NOW.md to get your live link!"
        echo ""
        echo "💡 To deploy and get a live URL, run:"
        echo "   open DEPLOY_NOW.md"
        echo ""
    else
        echo ""
        echo "❌ Push failed!"
        echo ""
        echo "🔧 Common solutions:"
        echo "   1. Use Personal Access Token as password (not your GitHub password)"
        echo "   2. Make sure repository exists on GitHub"
        echo "   3. Check your internet connection"
        echo ""
        echo "📖 For detailed help, see: PUSH_TO_GITHUB.md"
    fi
else
    echo ""
    echo "📝 To push later, use:"
    echo "   git push -u origin main"
    echo ""
    echo "📖 For detailed instructions, see: PUSH_TO_GITHUB.md"
fi

echo ""

