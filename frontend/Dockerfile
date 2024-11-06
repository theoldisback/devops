# Use Node 18 or newer
FROM node:18 AS build
# Change this line to Node.js 18 or higher

WORKDIR /app
COPY . .
RUN npm install
RUN npm run build -- --omit=dev

# Step 2: Serve the Angular app
FROM nginx:alpine
COPY --from=build /app/dist/front-app /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
